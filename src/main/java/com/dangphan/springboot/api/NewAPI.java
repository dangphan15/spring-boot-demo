package com.dangphan.springboot.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dangphan.springboot.api.output.NewOutput;
import com.dangphan.springboot.dto.NewDTO;
import com.dangphan.springboot.service.INewService;

@RestController

public class NewAPI {

	@Autowired
	private INewService newService;

	@GetMapping(value = "/new")
	public NewOutput showNew(@RequestParam("page") int page, @RequestParam("limit") int limit) {
		NewOutput result = new NewOutput();
		result.setPage(page);
		Pageable pageable = PageRequest.of(page - 1, limit);
		result.setListResult(newService.findAll(pageable));
		result.setTotalPage((int) Math.ceil((double) (newService.totalItem()) / limit));
		return result;
	}

	@GetMapping("/new/{id}")
	public NewDTO getNew(@PathVariable("id") long id) {

		return newService.find(id);
	}

	@GetMapping("/new/all")
	public List<NewDTO> getAll() {

		return newService.findAll();
	}

	@PostMapping("/new")

	public NewDTO createNew(@RequestBody NewDTO model) {

		return newService.save(model);

	}

	@PutMapping("/new/{id}")

	public NewDTO updateNew(@RequestBody NewDTO model, @PathVariable("id") long id) {

		model.setId(id);
		return newService.save(model);

	}

	@DeleteMapping("/new")

	public void deleteNew(@RequestBody long[] ids) {
		newService.delete(ids);
	}

}
