package model.svaeGame;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import model.tower.Tower;
import model.tower.TowerFactory;
import model.tower.shootingstrategy.TargetBasedOnNearest;
import model.tower.shootingstrategy.TargetBasedOnStrongest;
import model.tower.shootingstrategy.TargetBasedOnWeakest;
import model.tower.shootingstrategy.TowerBasedOnClosestToTower;
import view.map.Position;
import view.tower.TowerType;



public class GameCollection implements Serializable {

	
private ArrayList<GameInfo> games;
	
	public GameCollection(){
		
		this.games = new ArrayList<>();
	}


	public void addgame(GameInfo game){
		
		games.add(game);
	}

	  public ArrayList<GameInfo> getGames() {
	        return games;
	    }
	
	  public void print (){
		  System.out.println(games.size());
//		  
//			for (GameInfo game : games) {
//				System.out.println(game.getTowers().size());
//				System.out.println("*****************");
//				System.out.println(game.getGold());
//				System.out.println(game.getGameName());
//				System.out.println(game.getMapName());
//				System.out.println(game.getCoins());
//				System.out.println(game.getWaveNum());
//				Iterator it = game.getTowers().entrySet().iterator();
//				System.out.println(game.getTowers().size() + "  **************");
//				Tower tower;
//			    while (it.hasNext()) {
//			    	System.out.println("*****************");
//			        Map.Entry pair = (Map.Entry)it.next();
//			        tower = (Tower) pair.getValue();
//			        System.out.println(tower.getPosition().getX() + "  "  + tower.getPosition().getY());
//			        System.out.println(tower.getTowerShootingBehavior().getShootingStrategy().getClass().getSimpleName());
//			        System.out.println(tower.getLevel());
//			        System.out.println(tower.getClass().getSimpleName());
//			        it.remove(); // avoids a ConcurrentModificationException
//			        System.out.println("*****************");
//			    }
//			    System.out.println("*****************");
//			}
	  }
	  
		public void StoreInXMLFormate() throws FileNotFoundException{
			
			PrintWriter out;
			File selectedFile = new File("JSON_FILE.txt");
			 FileOutputStream stream = new FileOutputStream(selectedFile); 
             out = new PrintWriter( stream );
             
             out.println("<?xml version=\"1.0\"?>");
             out.println("<svaeGame version=\"1.0\">");
			for (int i = 0; i < games.size(); i++) {
					out.println("<Game>");
					GameInfo jsongames =games.get(i);
					out.println("<Towers>");
			        for (Map.Entry<Integer, Tower> entry : jsongames.getTowers().entrySet()) {
			        	Tower tower =entry.getValue();
			             out.println("<Type>"+tower.getClass().getSimpleName() +"</Type>");
			             out.println("<X>" + tower.getPosition().getX() + "</X>");
			             out.println("<Y>" + tower.getPosition().getY() + "</Y>");
			             out.println("<Level >"+tower.getLevel() +"</Level >");
			             out.println("<Range>" + tower.getRange() + "</Range>");
			             out.println("<Strategy>" + tower.getTowerShootingBehavior().getShootingStrategy().getClass().getSimpleName() + "</Strategy>"); 
			        }
			        out.println("</Towers>");
			        out.println("<WaveNumber>" + jsongames.getWaveNum() + "</WaveNumber>");
			        out.println("<MapName>" + jsongames.getMapName()+ "</MapName>");
			        out.println("<Coins>" + jsongames.getCoins() + "</Coins>");
			        out.println("<Balance>"  + jsongames.getGold() +"</Balance>");
			        out.println("<GameName>" + jsongames.getGameName() + "</GameName>");
			        out.println("</Game>");
					}
					out.println("</svaeGame>");
					out.close();
	}
		
		public void readXMLFormate() throws Exception{
			
          	HashMap<Integer,Tower> towersCollection = new HashMap<Integer,Tower> ();
        	int count = 0;
        	Tower tower = null;
        	String mapName ="", gameName = "";
    		GameInfo newGame;
			int level = 0, waveNum = 0 , coins = 0;
			double balance = 0;
			String towerType = "   " , towerStrategy = "   "  ; 
			 int towerLevel = 0 ,posX = 0 ,posY = 0;
			 int range = 0;
			
			 Document xmldoc;
			 DocumentBuilder docReader = DocumentBuilderFactory.newInstance().newDocumentBuilder();
             xmldoc = docReader.parse("JSON_FILE.txt");
             Element rootElement = xmldoc.getDocumentElement();
                    NodeList nodes = rootElement.getChildNodes();
                    for (int i = 0; i < nodes.getLength(); i++) {
                        if (nodes.item(i) instanceof Element) {
                            Element element = (Element)nodes.item(i);
                            if (element.getTagName().equals("Game")) {
                            	NodeList curveNodesGame = element.getChildNodes();
                            	 for (int j = 0; j < curveNodesGame.getLength(); j++) {
                                     if (curveNodesGame.item(j) instanceof Element) {
                                         Element curveOfGameElement = (Element)curveNodesGame.item(j);
                                         if (curveOfGameElement.getTagName().equals("GameName")) {
                                        	 gameName = curveOfGameElement.getTextContent();
                                         }else if (curveOfGameElement.getTagName().equals("MapName")) { 
                                        	 mapName =curveOfGameElement.getTextContent();
                                         }else if(curveOfGameElement.getTagName().equals("WaveNumber")) {
                                        	  waveNum = Integer.parseInt(curveOfGameElement.getTextContent());
                                         }else if(curveOfGameElement.getTagName().equals("Coins")){
                                        	 coins = Integer.parseInt(curveOfGameElement.getTextContent());
                                         }else if(curveOfGameElement.getTagName().equals("Balance")){
                                        	 balance = Double.parseDouble(curveOfGameElement.getTextContent());
                                         }else if(curveOfGameElement.getTagName().equals("Towers")){
                                        	 NodeList curveTowers = curveOfGameElement.getChildNodes();
                                        	 for (int jJ = 0; jJ < curveTowers.getLength(); jJ++) {
                                                 if (curveTowers.item(jJ) instanceof Element) {
                                                     Element curveOfTowerElement = (Element)curveTowers.item(jJ);
                                                     if(curveOfTowerElement.getTagName().equals("Type")){
                                                    	 towerType =curveOfTowerElement.getTextContent();                	
                                                     } else if(curveOfTowerElement.getTagName().equals("Strategy")){
                                                    	 towerStrategy = curveOfTowerElement.getTextContent();
                                                     }else if(curveOfTowerElement.getTagName().equals("X")){
                                                    	 posX = Integer.parseInt(curveOfTowerElement.getTextContent());
                                                     }else if(curveOfTowerElement.getTagName().equals("Y")){
                                                    	 posY = Integer.parseInt(curveOfTowerElement.getTextContent());
                                                     }else if(curveOfTowerElement.getTagName().equals("Level")){
                                                    	 towerLevel = Integer.parseInt(curveOfTowerElement.getTextContent());
                                                     }else if (curveOfTowerElement.getTagName().equals("Range")){
                                                    	 range = Integer.parseInt(curveOfTowerElement.getTextContent());
                                                     } 
                                                     
                                                    	 
                                                 
                                                 switch(towerType){
                                                 case "BurningTower":
                                                	 tower = TowerFactory.sharedInstance().getTower(TowerType.BurningTower1);
                                                	 break;
                                                 case "IceTower":
                                                	 tower = TowerFactory.sharedInstance().getTower(TowerType.IceTower1);
                                                	 break;
                                                 case "SplashTower":
                                                	 tower = TowerFactory.sharedInstance().getTower(TowerType.SplashTower1);
                                                	 break;	 
                                                 }
                                                 switch(towerStrategy){
                                                 case "TargetBasedOnNearest":
                                                	 tower.getTowerShootingBehavior().setShootingStrategy(new TargetBasedOnNearest());
                                                	 break;
                                                 case "TargetBasedOnStrongest":
                                                	 tower.getTowerShootingBehavior().setShootingStrategy(new TargetBasedOnStrongest());
                                                	 break;
                                                 case "TargetBasedOnWeakest":
                                                	 tower.getTowerShootingBehavior().setShootingStrategy(new TargetBasedOnWeakest());
                                                	 break;
                                                 case "TowerBasedOnClosestToTower":
                                                	 tower.getTowerShootingBehavior().setShootingStrategy(new TowerBasedOnClosestToTower());
                                                	 break;	 	 
                                        	 }
                                                
                                         }
                                     }
                                        	 tower.setRange(range);
                                             tower.setPosition(new Position(posX,posY));
                                             tower.setLevel(towerLevel);
                                             towersCollection.put(count, tower);
                                             count++; 
                            	 }
                                      //System.out.println(towerStrategy +   "||"  + mapName +"||"+ gameName + "||"  + "||" + posX + "||" + posY +"||" + towerType + "||" + towerLevel + "||" + coins+ "||" +balance + "||" + waveNum);
                                     
                            }
                        }
                            	 newGame = new GameInfo(towersCollection, balance , coins , waveNum,gameName, mapName);
                                 games.add(newGame);
                                 towersCollection = new HashMap<Integer,Tower> ();

                       
		}
}
}
}
}