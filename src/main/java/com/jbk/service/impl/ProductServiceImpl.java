package com.jbk.service.impl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.jbk.dao.ProductDao;
import com.jbk.entity.ProductEntity;
import com.jbk.model.Category;
import com.jbk.model.Product;
import com.jbk.model.Supplier;
import com.jbk.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao dao;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public int addProduct(Product product) {

if(product.getProductId()==0) {
	
}
		return dao.addProduct(modelMapper.map(product, ProductEntity.class));
	}

	@Override
	public List<Product> deleteProduct(long productId) {
		List<ProductEntity> list = dao.deleteProduct(productId);
		return list.stream().map(productEntity -> modelMapper.map(productEntity, Product.class))
				.collect(Collectors.toList());
	}

	@Override
	public Product getProductById(long productId) {

		ProductEntity productEntity = dao.getProductById(productId);
		if (productEntity != null) {
			return modelMapper.map(productEntity, Product.class);
		} else {
			return null;
		}
	}

	@Override
	public List<Product> getAllProduct() {
		List<ProductEntity> list = dao.getAllProduct();
		return list.stream().map(productEntity -> modelMapper.map(productEntity, Product.class))
				.collect(Collectors.toList());
	}

	@Override
	public Product updateProduct(Product product) {
		ProductEntity updatedProduct = dao.updateProduct(modelMapper.map(product, ProductEntity.class));
		return modelMapper.map(updatedProduct, Product.class);
	}

	@Override
	public List<Product> getAllProductsByOrder(String orderType, String propertyName) {
		List<ProductEntity> list = dao.getAllProductsByOrder(orderType, propertyName);

		return list.stream().map(productEntity -> modelMapper.map(productEntity, Product.class))
				.collect(Collectors.toList());
	}

	@Override
	public String uploadSheet(MultipartFile file) {

		String fileName = file.getOriginalFilename();

		// upload file

		try {
			FileOutputStream fos = new FileOutputStream("src/main/resources/" + fileName);

			try {
				byte[] data = file.getBytes();
				fos.write(data);
			} catch (IOException e) {
				e.printStackTrace();
			}

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}

		// read excel data

		List<Product> list = readExcel("src/main/resources/" + fileName);
		
		for (Product product : list) {
			
			
			addProduct(product);
		}

		

		return null;
	}

	private List<Product> readExcel(String filePath) {
		List<Product> list = new ArrayList<Product>();
		try {
			// FileInputStream fis=new FileInputStream(filePath);

			Workbook workbook = new XSSFWorkbook(filePath);
			Sheet sheet = workbook.getSheetAt(0);

			Iterator<Row> rows = sheet.rowIterator();

			while (rows.hasNext()) {
				Row row = (Row) rows.next();

				int rowNum = row.getRowNum();
				if (rowNum == 0) {
					continue;
				}

				Product product = new Product();
				String productId = new SimpleDateFormat("yyyyMMddHHmmss").format(new java.util.Date());

				product.setProductId(Long.parseLong(productId) + rowNum);

				Iterator<Cell> cells = row.cellIterator();

				while (cells.hasNext()) {
					Cell cell = (Cell) cells.next();

					int columnIndex = cell.getColumnIndex();

					switch (columnIndex) {
					case 0:
						product.setProductName(cell.getStringCellValue());
						break;

					case 1:
						Supplier supplier = new Supplier();
						supplier.setSupplierId((long) cell.getNumericCellValue());
						product.setSupplier(supplier);
						break;

					case 2:
						Category category = new Category();
						category.setCategoryId((long) cell.getNumericCellValue());
						product.setCategory(category);
						break;

					case 3:
						product.setProductQty((int) cell.getNumericCellValue());
						break;

					case 4:
						product.setProductPrice(cell.getNumericCellValue());
						break;

					}

				}
				list.add(product);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;

	}

}
