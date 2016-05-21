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
    String sName;


    @Override
    public void init(Entity entity) {
        button= entity;
        button.getComponent(ButtonComponent.class).addListener(new ButtonComponent.ButtonListener(){
            @Override
            public void touchUp() {

            }
            @Override
            public void touchDown() {
                System.out.println(sName);
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
    public void getText(String sText){
        sName= sText;
    }
}
