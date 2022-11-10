package com.dangphan.springboot.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import com.dangphan.springboot.api.output.NewOutput;
import com.dangphan.springboot.dto.NewDTO;
import com.dangphan.springboot.service.INewService;

@RestController
@RequestMapping("/api/news")
public class NewAPI {

	@Autowired
	private INewService newService;

	@GetMapping(value = "")
	public NewOutput showNew(@RequestParam("page") int page, @RequestParam("limit") int limit) {

		NewOutput result = new NewOutput();
		result.setPage(page);
		Pageable pageable = PageRequest.of(page - 1, limit);
		result.setListResult(newService.findAll(pageable));
		result.setTotalPage((int) Math.ceil((double) (newService.totalItem()) / limit));
		return result;
	}

	@GetMapping("/{id}")
	public NewDTO getNew(@PathVariable("id") long id) {

		return newService.find(id);
	}

	@GetMapping("/all")
	public List<NewDTO> getAll() {

		return newService.findAll();

	}

	@PostMapping("")
	public NewDTO createNew(@RequestBody NewDTO model) {

		return newService.save(model);

	}

	@PutMapping("/{id}")
	public NewDTO updateNew(@RequestBody NewDTO model, @PathVariable("id") long id) {

		model.setId(id);
		return newService.save(model);

	}

	@DeleteMapping("")
	public void deleteNew(@RequestBody long[] ids) {

		newService.delete(ids);

	}

}
