package com.codegym.cm.controller;

import com.codegym.cm.model.City;
import com.codegym.cm.model.Country;
import com.codegym.cm.service.city.ICityService;
import com.codegym.cm.service.conntry.ICountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/city")
public class CityController {

    @Autowired
    private ICityService cityService;

    @Autowired
    private ICountryService countryService;

    @ModelAttribute("countries")
    public Iterable<Country> countries(){
        return countryService.findAll();
    }

    @GetMapping("/list")
    public ModelAndView listCity() {
        Iterable<City> cities = cityService.findAll();
        ModelAndView modelAndView = new ModelAndView("/city/list");
        modelAndView.addObject("cities", cities);
        return modelAndView;
    }

    @GetMapping("create-form")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("/city/create");
        modelAndView.addObject("city", new City());
        return modelAndView;
    }

    @PostMapping("/save-city")
    public ModelAndView createCity(@ModelAttribute("city") City city){
        cityService.save(city);
        Iterable<City> cities = cityService.findAll();
        ModelAndView modelAndView = new ModelAndView("/city/create");
        modelAndView.addObject("cities", cities);
        modelAndView.addObject("city", new City());
        modelAndView.addObject("message", "New city created successfully");
        return modelAndView;
    }

    @GetMapping("/delete-city/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id) {
        Optional<City> city = cityService.findById(id);
        if (city.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("/city/delete");
            modelAndView.addObject("city", city.get());
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("/layout/error");
            return modelAndView;
        }
    }

    @GetMapping("/view-city/{id}")
    public ModelAndView showCityInfo(@PathVariable Long id) {
        Optional<City> city = cityService.findById(id);
        if (city.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("/city/view");
            modelAndView.addObject("city", city.get());
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("/layout/error");
            return modelAndView;
        }
    }

    @GetMapping("/edit-city/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) {
        Optional<City> city = cityService.findById(id);
        if (city.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("/city/edit");
            modelAndView.addObject("city", city.get());
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("/layout/error");
            return modelAndView;
        }
    }

    @PostMapping(value = "edit-city")
    public String updateCity(City city, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("message","Update information successfully");
        cityService.save(city);
        return "redirect:/city/list";
    }

    @PostMapping("/delete-city")
    public String deleteCity(Model model, City city, RedirectAttributes redirectAttributes){
        Iterable<City> cities = cityService.findAll();
        model.addAttribute("cities",cities);
        String name = cityService.findById(city.getId()).get().getName();
        cityService.remove(city.getId());
        redirectAttributes.addFlashAttribute("message", name +" City" + " " +"deleted successfully");
        return "redirect:/city/list";
    }
}
