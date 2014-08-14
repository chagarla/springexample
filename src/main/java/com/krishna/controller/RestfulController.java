package com.krishna.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.krishna.bean.Person;

@Controller
public class RestfulController extends AbstractController {

  @RequestMapping(value = "/name", method = RequestMethod.GET, produces = "text/plain")
  public @ResponseBody
  String getName() {
    return "Restful Krishna";
  }

  @RequestMapping(value = "/person", method = RequestMethod.GET, produces = "application/json")
  public @ResponseBody
  Person getPerson() {
    return new Person("1", "Krishna");
  }

  @Override
  protected ModelAndView handleRequestInternal(HttpServletRequest request,
      HttpServletResponse response) throws Exception {
    // TODO Auto-generated method stub
    return null;
  }

  @RequestMapping(value = "/view", method = RequestMethod.GET)
  public ModelAndView renderView(ModelAndView mav, HttpServletRequest httpServletRequest) {

    mav.setViewName("/personview");

    mav.getModel().put("PERSON", new Person("2", "viewperson"));
    return mav;
  }

}
