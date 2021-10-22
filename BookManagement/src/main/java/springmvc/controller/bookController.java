package springmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import springmvc.dao.bookDao;
import springmvc.model.book;

@Controller
public class bookController {

	@Autowired  
	bookDao dao;
	
	@RequestMapping("/index")
	public String index() 
	{
		return "index";	
	}
	
    @RequestMapping("/bookform")    
    public String showform(Model m){    
        m.addAttribute("command", new book());  
        return "bookform";   
    }   
    
    @RequestMapping(value="/save",method = RequestMethod.POST)    
    public String save(@ModelAttribute("b") book b){    
        dao.save(b);    
        return "redirect:/viewbook";   
    }    
    
    @RequestMapping("/viewbook")    
    public String viewcountry(Model m){    
        List<book> list=dao.getBooks();    
        m.addAttribute("list",list);  
        return "viewbook";    
    }   
    
    @RequestMapping(value="/editbook/{id}")    
    public String edit(@PathVariable int id, Model m){    
    	book b=dao.getbookById(id);    
        m.addAttribute("command",b);  
        return "bookeditform";    
    }    

    @RequestMapping(value="/editsave",method = RequestMethod.POST)    
    public String editsave(@ModelAttribute("b") book b){    
        dao.update(b);    
        return "redirect:/viewbook";    
    }    
 
    @RequestMapping(value="/deletebook/{id}",method = RequestMethod.GET)    
    public String delete(@ModelAttribute("b") book b){    
        dao.delete(b);    
        return "redirect:/viewbook";    
    } 

}
