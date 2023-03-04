package com.rentacar.springcamp.webApi.controller;

import com.rentacar.springcamp.business.abstarcats.BrandService;
import com.rentacar.springcamp.business.requests.CreateBrandRequest;
import com.rentacar.springcamp.business.requests.UpdateBrandRequest;
import com.rentacar.springcamp.business.response.GetAllBrandResponse;
import com.rentacar.springcamp.business.response.GetByIdBrandResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/brands")
@AllArgsConstructor
public class BrandController {
    private BrandService brandService;

    @GetMapping()
    public List<GetAllBrandResponse> getAll() {
        return brandService.getAll();
    }

    @PostMapping()
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody() CreateBrandRequest createBrandRequest) {
        this.brandService.add(createBrandRequest);
    }

    @GetMapping("/{id}")
    public GetByIdBrandResponse getById(@PathVariable int id) {
        return brandService.getById(id);
    }

    @PutMapping
    public void update(@RequestBody UpdateBrandRequest updateBrandRequest) {
        this.brandService.update(updateBrandRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        this.brandService.delete(id);
    }
}
