package com.usa.misiontic.masterclass3.repository;

import com.usa.misiontic.masterclass3.entities.Tools;
import com.usa.misiontic.masterclass3.repository.crudRepository.ToolsCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ToolsRepository {
    @Autowired
    private ToolsCrudRepository toolsRepository;

    public List<Tools> getAll(){
        return (List<Tools>) toolsRepository.findAll();}
    public Optional<Tools> getTools(int id){
        return toolsRepository.findById(id);
    }
    public Tools save(Tools c){
        return toolsRepository.save(c);
    }
    public void delete(Tools c){
        toolsRepository.delete(c);
    }
}
