package com.project.moneymanager.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.moneymanager.models.Category;
import com.project.moneymanager.models.Expense;
import com.project.moneymanager.models.Income;
import com.project.moneymanager.models.Plan;
import com.project.moneymanager.models.Role;
import com.project.moneymanager.models.User;
import com.project.moneymanager.services.MainSer;
import com.project.moneymanager.services.UserService;

@RestController
public class testController {
	private final UserService userser;
	private final MainSer mainser;
	
    public testController(UserService userser, MainSer mainser) {
		super();
		this.userser = userser;
		this.mainser = mainser;
	}
    //display
	@RequestMapping("/roles")
    public List<Role> displayroles() {
        return mainser.findAllRoll();
    }
	
	@RequestMapping("/categorys")
    public List<Category> displaycat(HttpSession session) {
        return mainser.findAllCategory();
    }
	@RequestMapping("/role")
    public List<Role> displayrole(HttpSession session) {
		if((boolean) session.getAttribute("user")) {
			User user=(User) session.getAttribute("user");
			return user.getRoles();
		}
        return null;
    }
    @RequestMapping("/expenses")
    public List<Expense> displayexpense(HttpSession session) {
    	if((boolean) session.getAttribute("user")) {
			User user=(User) session.getAttribute("user");
			List<Plan> plans=user.getPlans();
			List<Expense> expenses=null;
			int total=0;
			for(Plan p:plans) {
				List<Expense> exp=p.getExpenses();
				for(Expense e:exp) {
					total+=e.getAmount();
					expenses.add(e);
				}
			}
			return expenses;
		}
    	return null;
    }
    
    @RequestMapping("/incomes")
    public List<Income> displayincome(HttpSession session) {
    	if((boolean) session.getAttribute("user")) {
			User user=(User) session.getAttribute("user");
			return user.getIncomes();
    	}
        return null;
    }
    	
	@RequestMapping("/planes")
    public List<Plan> displayplan(HttpSession session) {
    	if((boolean) session.getAttribute("user")) {
			User user=(User) session.getAttribute("user");
			return user.getPlans();
    	}
        return null;
    }	


    
    //creation
    
	@RequestMapping(value="/role",method=RequestMethod.POST)
    public User createrole(@RequestParam(value="name") String name) {
        return maincont.createrole(name);
    }
	@RequestMapping(value="/role",method=RequestMethod.POST)
    public User createrole(@RequestParam(value="name") String name) {
        return maincont.createrole(name);
    }
	@RequestMapping(value="/role",method=RequestMethod.POST)
    public User createrole(@RequestParam(value="name") String name) {
        return maincont.createrole(name);
    }

}