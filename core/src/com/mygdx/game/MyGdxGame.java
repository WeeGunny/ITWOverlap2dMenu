package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
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
//The sources for Overlap 2D are very hard to find, the amount that has changed between versions is
//immense with the latest version being a complete rewrite of the how you implement overlap2d into your code
//I used their newest pieces of their latest video series https://www.youtube.com/watch?v=bhvHm2sM0qo
public class MyGdxGame extends ApplicationAdapter{
	// Create a Scene Loader and a view Port
	private SceneLoader sceneLoader;
	private Viewport viewport;
	//item wrapper will make it easier to access the object in your scene
	ItemWrapper root;


	
	@Override
	public void create () {
		ButtonScript buttonScript= new ButtonScript();
		// Overlap 2d uses world units, instead of pixels, so this is the size
		// of the camera I need for my specific game world;
		viewport= new FitViewport(24,15);
		sceneLoader= new SceneLoader();
		//Loads in a scene and uses the viewport that I have created.
		sceneLoader.loadScene("MainScene",viewport);
		//in overlap 2d you can add tags to object, this is adding button component to any item
		//tagged with "button"
		sceneLoader.addComponentsByTagName("button", ButtonComponent.class);
		root= new ItemWrapper(sceneLoader.getRoot());
		// this is getting the different objects from the root and adding the button Script
		// I created to each one.
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
		// getEngine is an ashley command which is what overlap2d current uses to render objects
		sceneLoader.getEngine().update(Gdx.graphics.getDeltaTime());
	}
}
