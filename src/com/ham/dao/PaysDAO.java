package com.ham.dao;

import java.util.ArrayList;

import com.ham.entities.Pays;

public interface PaysDAO {

    public Pays getPays(String id);
    public ArrayList<Pays> getAllPays();

}
