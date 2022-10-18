
package com.tienda.controller;
import com.tienda.domain.Cliente;
import com.tienda.dao.ClienteDao;
import com.tienda.service.ClienteService;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    
    @Autowired
    private ClienteService clienteService;
    
    @GetMapping("/")
    public String inicio(Model model) {
        var texto="Estamos en semana 4";
        model.addAttribute("mensaje", texto);
        
        
       var clientes = clienteService.getClientes();
         
        model.addAttribute("clientes", clientes);
                
        return "index";
    }
    
}
