package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.sun.glass.ui.Screen;
import com.uwsoft.editor.renderer.SceneLoader;
import com.uwsoft.editor.renderer.components.additional.ButtonComponent;
import com.uwsoft.editor.renderer.utils.ItemWrapper;

import java.awt.Font;

public class MyGdxGame extends ApplicationAdapter {
	private SceneLoader sceneLoader;
	private Viewport viewport;
	ItemWrapper root;
	String[] strings= {"beans","shoes","bread","knife"};

	
	@Override
	public void create () {
		ButtonScript buttonScript= new ButtonScript();
		viewport= new FitViewport(24,15);
		sceneLoader= new SceneLoader();
		sceneLoader.loadScene("MainScene",viewport);
		sceneLoader.addComponentsByTagName("button", ButtonComponent.class);
		root= new ItemWrapper(sceneLoader.getRoot());
		buttonScript.getText(strings[0]);
		root.getChild("button").addScript(buttonScript);
		root.getChild("button2").addScript(buttonScript);
		root.getChild("button3").addScript(buttonScript);
		root.getChild("button4").addScript(buttonScript);
		root.getChild("button5").addScript(buttonScript);
		root.getChild("button6").addScript(buttonScript);




	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		sceneLoader.getEngine().update(Gdx.graphics.getDeltaTime());
	}
}
