package com.tienda.service;

import com.tienda.dao.CategoriaDao;
import com.tienda.domain.Categoria;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CategoriaServiceImp implements CategoriaService {
    //se implementan los 4 metodos de un CRUD
    //Create Read Update Delete mediante CategoriaDao
    
    //Se utiliza una anotación  Autowired para que el objeto categoriaDao
    //Si ya esta en memoria se usa ese... sino se crea (patron singleton)
    @Autowired
    private CategoriaDao categoriaDao;
    
    //Retorna la lista de categorias
    @Override
    @Transactional(readOnly = true)
    public List<Categoria> getCategorias(boolean activos) { 
        var lista = (List<Categoria>)categoriaDao.findAll();
        
         if (activos){ //Sólo las categorias activas
            lista.removeIf(e -> !e.isActivos());   
        }
        
        return lista;
    }
    
    //Dado un categoria.id se busca en la tabla y se retorna todo el objeto Categoria
    @Override
    @Transactional(readOnly = true)
    public Categoria getCategoria(Categoria categoria) { 
        return categoriaDao.findById(categoria.getIdCategoria()).orElse(null);
    }
    //Si el categoria.id tiene un valor se busca y se actualiza
    //Si el categoria.id No tiene valor, se inserta el objeto en la tabla
    @Override
    @Transactional
    public void save(Categoria categoria){
        categoriaDao.save(categoria);
    }
    
    
    //Elimina el registro que tiene el id igual a categoria.id
    @Override
    @Transactional
    public void delete(Categoria categoria){
        categoriaDao.delete(categoria);
    }
    
    
}
    
    

