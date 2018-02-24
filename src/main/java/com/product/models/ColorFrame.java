package com.product.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;
import java.util.Random;
@Component
public class ColorFrame extends JFrame {

    @Autowired
    private Color color;

    public ColorFrame() {
        setSize (200, 200);
        setVisible (true);
        setDefaultCloseOperation (WindowConstants.EXIT_ON_CLOSE);
    }

    public void showOnRandomColor() {
        Random random = new Random ();
        setLocation (random.nextInt (1000), random.nextInt (500));
        getContentPane ().setBackground (color);
        repaint ();
    }
}
