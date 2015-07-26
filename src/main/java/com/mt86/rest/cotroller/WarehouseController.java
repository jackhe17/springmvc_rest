package com.mt86.rest.cotroller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.junit.runner.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

import com.mt86.rest.exception.ProductNotFoundException;
import com.mt86.rest.model.Product;
import com.mt86.rest.model.Warehouse;
import com.mt86.rest.repository.WarehouseRepository;

@Controller
public class WarehouseController {
	private static Logger logger = Logger.getLogger(WarehouseController.class);
	
	@Autowired
	private WarehouseRepository warehouseRepository;
	
	/**
	 * get warehouse by id
	 * @param wid
	 * @return
	 */
	@RequestMapping(value="w/{wid}", method=RequestMethod.GET)
	public @ResponseBody Warehouse getWarehouse(@PathVariable("wid") int wid){
		return warehouseRepository.getWarehouse(wid);
	}
	
	/**
	 * add product to warehouse
	 * @param wid
	 * @param product
	 * @param request
	 * @param response
	 */
	@RequestMapping(value="w/{wid}/p",method=RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public void addProduct(@PathVariable("wid")int wid,@RequestBody Product product,
			HttpServletRequest request,HttpServletResponse response){
		warehouseRepository.addProduct(wid, product);
		response.setHeader("Location", request.getRequestURL().append("/").append(product.getId()).toString());
	}
	
	@RequestMapping(value="w/{wid}/p/{pid}",method=RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void removeProduct(@PathVariable("wid") int wid,@PathVariable int pid,
			HttpServletRequest request,HttpServletResponse response){
		warehouseRepository.removeProduct(wid, pid);
	}
	
	@RequestMapping(value="w/{wid}/p{pid}", method=RequestMethod.GET)
	public Product getProduct(@PathVariable("wid")int wid,@PathVariable("pid")int pid){
		return warehouseRepository.getProduct(wid, pid);
	}
	
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(ProductNotFoundException.class)
	public void handleProductNotFound(ProductNotFoundException pe){
		logger.warn("product not found");
	}
	@InitBinder
	public void testBinder(WebDataBinder binder, WebRequest req) {
		System.out.println();
	}
}
