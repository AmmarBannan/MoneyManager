//package com.project.moneymanager.controllers;
//
//import java.security.Principal;
//import java.util.Date;
//import java.util.List;
//
//import javax.servlet.http.HttpSession;
//
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.project.moneymanager.models.Category;
//import com.project.moneymanager.models.Expense;
//import com.project.moneymanager.models.Income;
//import com.project.moneymanager.models.Plan;
//import com.project.moneymanager.models.Role;
//import com.project.moneymanager.models.User;
//import com.project.moneymanager.services.MainSer;
//import com.project.moneymanager.services.UserService;
//
//@RestController
//public class testController {
//	private final UserService userser;
//	private final MainSer mainser;
//
//    public testController(UserService userser, MainSer mainser) {
//		super();
//		this.userser = userser;
//		this.mainser = mainser;
//	}
//    //display
//	@RequestMapping("/roles")
//    public List<Role> displayroles() {
//        return mainser.findAllRoll();
//    }
//
//	@RequestMapping("/categorys")
//    public List<Category> displaycat(HttpSession session) {
//        return mainser.findAllCategory();
//    }
//	@RequestMapping("/role")
//    public List<Role> displayrole(HttpSession session) {
//		if((boolean) session.getAttribute("user")) {
//			User user=(User) session.getAttribute("user");
//			return user.getRoles();
//		}
//        return null;
//    }
//    @RequestMapping("/expenses")
//    public List<Expense> displayexpense(Principal principal) {
//			String name=principal.getName();
//			User usre=mainser.f
//			List<Plan> plans=user.getPlans();
//			List<Expense> expenses=null;
//			int total=0;
//			for(Plan p:plans) {
//				List<Expense> exp=p.getExpenses();
//				for(Expense e:exp) {
//					total+=e.getAmount();
//					expenses.add(e);
//				}
//			}
//			return expenses;
//		}
//    	return null;
//    }
//
//    @RequestMapping("/incomes")
//    public List<Income> displayincome(Model model ){
//
//        return null;
//    }
//
//	@RequestMapping("/planes")
//    public List<Plan> displayplan(HttpSession session) {
//    	if((boolean) session.getAttribute("user")) {
//			User user=(User) session.getAttribute("user");
//			return user.getPlans();
//    	}
//        return null;
//    }
//
//
//    //creation
//@RequestMapping(value="/role",method=RequestMethod.POST)
//    public Role createrole(@RequestParam(value="name") String name) {
//        Role role=new Role(name);
//        return role;
//    }
//    @RequestMapping(value="/plan",method=RequestMethod.POST)
//    public Plan createplan(@RequestParam(value="name") String name,@RequestParam(value="limit") int limit,
//            @RequestParam(value="start_data") Date start_data,@RequestParam(value="end_data") Date end_data,
//            HttpSession session) {
//        if((boolean) session.getAttribute("user")) {
//            User user=userser.findById((Long) session.getAttribute("id"));
//            Plan plan=new Plan(name,limit,start_data,end_data,user);
//            return plan;
//        }
//        return null;
//    }
////    @RequestMapping(value="/expense",method=RequestMethod.POST)
////     public User createexpense(@RequestParam(value="amount") int amount, @RequestParam(value="description") String description,
////                               @RequestParam(value="date") Date date, @RequestParam(value="category") Category category, HttpSession session) {
////            if((boolean) session.getAttribute("user")) {
////                User user=userser.findById((Long) session.getAttribute("id"));
////                Plan plan=
////                Expense exp = new Expense(amount, description, date, plan, category);
////
////            }
////            return null;
////        }
//
//}
