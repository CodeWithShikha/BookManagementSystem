package springmvc.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import springmvc.model.book;
import springmvc.model.book;

@Transactional
@Repository
public class bookDao {
	
HibernateTemplate template;  
    
	public void setTemplate(HibernateTemplate template) {    
	    this.template = template;    
	} 

	public void save(book b){    
	    template.save(b);    
	}    
	public void update(book b){    
	   template.update(b);    
	}    
	public void delete(book b){    
	   template.delete(b);    
	}    


	public book getbookById(int id){    
		book b = (book)this.template.get(book.class, id);
	    return b;  
	}    
	
	
	public List<book> getBooks(){    
		List<book> list=new ArrayList<book>();  
	    list=template.loadAll(book.class);  
	    return list;     
	}  

}
