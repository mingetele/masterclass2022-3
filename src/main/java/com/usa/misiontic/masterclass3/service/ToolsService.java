package com.usa.misiontic.masterclass3.service;

import com.usa.misiontic.masterclass3.entities.Category;
import com.usa.misiontic.masterclass3.entities.Tools;
import com.usa.misiontic.masterclass3.repository.ToolsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ToolsService {

    @Autowired
    private ToolsRepository toolsRepository;

    public List<Tools> getAll(){
        return toolsRepository.getAll();
    }
    public Optional<Tools> getTools(int id){
        return toolsRepository.getTools(id);
    }
    public Tools save(Tools p) {
        if (p.getId() == null) {
            return toolsRepository.save(p);
        } else {
            Optional<Tools> e = toolsRepository.getTools(p.getId());
            if (e.isPresent()) {
                return p;
            } else {
                return toolsRepository.save(p);
            }
        }

    }
    public Tools update(Tools p) {
        if (p.getId() != null) {
            Optional<Tools> q = toolsRepository.getTools(p.getId());
            if (q.isPresent()) {
                if (p.getName() != null) {
                    q.get().setName((p.getName()));
                }
                if (p.getBrand() != null) {
                    q.get().setBrand((p.getBrand()));
                }
                if (p.getYear() != null) {
                    q.get().setYear((p.getYear()));
                }
                if (p.getDescription() != null) {
                    q.get().setDescription((p.getDescription()));
                }
                if (p.getCategory() != null) {
                    q.get().setCategory((p.getCategory()));
                }
                toolsRepository.save(q.get());
                return q.get();
            } else {
                return p;
            }
        }else{
            return p;
        }

    }
    public boolean delete(int id){
        boolean flag=false;
        Optional<Tools>p= toolsRepository.getTools(id);
        if(p.isPresent()){
            toolsRepository.delete(p.get());
            flag=true;
        }
        return flag;
    }
}
