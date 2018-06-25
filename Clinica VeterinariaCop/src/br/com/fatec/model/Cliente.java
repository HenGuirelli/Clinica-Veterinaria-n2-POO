package br.com.fatec.model;

import java.util.ArrayList;
import java.util.List;

public class Cliente extends Pessoa{    
    private List<Animal> animais;
    
    public Cliente(){
        animais = new ArrayList();
    }
    
    public List<Animal> getAnimais(){
        return animais;
    }
    
    public void addAnimal(Animal animal){
        animais.add(animal);
    }
    
    public void removeAnimal(Animal animal){
        animais.remove(animal);
    }   
    
    
}
