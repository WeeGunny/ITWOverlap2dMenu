package com.mygdx.game;

import com.badlogic.ashley.core.Entity;
import com.uwsoft.editor.renderer.components.TransformComponent;
import com.uwsoft.editor.renderer.components.additional.ButtonComponent;
import com.uwsoft.editor.renderer.scripts.IScript;

/**
 * Created by Luke on 2016-05-20.
 */
public class ButtonScript implements IScript{

    private Entity button;



    @Override
    //method takes in an Entity which is an object from the stage
    public void init(Entity entity) {
        button= entity;
        // adds a listener to the Entity's button component which was added in the main file
        button.getComponent(ButtonComponent.class).addListener(new ButtonComponent.ButtonListener(){
            @Override
            public void touchUp() {

            }
            @Override
            public void touchDown() {
                System.out.println("ive been Clicked");
            }
            @Override
            public void clicked() {
            }
        });
    }

    @Override
    public void act(float delta) {



    }

    @Override
    public void dispose() {

    }
}
