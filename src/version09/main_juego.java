package version09;
import java.util.ArrayList;

import processing.core.*;


public class main_juego extends PApplet{
	
	/*-----------------------------------------------------------------------------------------------------
	int id_ataques = 100, id_stats = 200;
	String[] sAtk = {"A", "B", "C", "D"};
	String[] sStats = {"vida: 20/20", "mana: 10/10"};
	String n_fondo = "fondo.jpg";
	static String n_botones="botones.png";
	//-----------------------------------------------------------------------------------------------------*/
	
	public main_juego() {
		PApplet.main("version09.main");
	}
	
	int estado_mouse = 0;
	
	
	
	public void settings() {
		size(1280,720);
	}
	
	public void setup() {
		fill(100);
		noStroke();
	}
	
	public void preparar() {
		settings();
		setup();
	}
	
	/*public void draw() {
		int estado = 0;
		switch(estado) {
		case 0:
			menu_Habilidades(sAtk, sStats, n_fondo, id_stats, id_ataques);
		break;
		}
		
	}*/

	
	public void verificarclics(ArrayList <menu> menues) {
		if(estado_mouse == 37) {
			int[] selec = new int[menues.size()];
			for(int i = 0; i < menues.size(); i++) {
				selec[i] = menues.get(i).menu_selec();
				if(selec[i] > 0) {
					System.out.print(selec[i]);
				}
			}
			estado_mouse = 0;
		}
	}
	
	public void menu_Habilidades(String[] sAtk, String[] sStats, String n_fondo, int id_stats, int id_ataques) {
		stroke(0);
		ArrayList <menu> menues = new ArrayList <menu>();
		textura fondo = new textura(n_fondo, 0, 0, width, height*3/4, this);
		menu ataques = new menu(0, height*3/4, width/4, height/4, id_ataques, sAtk.length, sAtk, this);
		menues.add(ataques);
		menu stats = new menu(width/4, height*3/4, width*3/4, height/4, id_stats, sStats.length, sStats, this);
		menues.add(stats);
		ataques.genselecs();
		stats.genselecs();
		fondo.dibujar();
		verificarclics(menues);
	}
	
	public void mouseClicked() {
		estado_mouse = mouseButton;
	}
	/*
	@Override
	public void keyReleased(){
		if(key == 'R' ||key == 'r'){
			
		}
		if(key == CODED){
		    if(keyCode == RIGHT){
		    	
		    }
		    if(keyCode == LEFT){
		    	
		    }
		    if(keyCode == UP){
		    	
		    }
		    if(keyCode == DOWN){
		    	
		    }
		}
	}
	
	/*public void keyReleased(){
	  if(key == CODED){
	    if(keyCode == RIGHT||keyCode == LEFT)jugador.vx=0;
	  }
	}*/
}