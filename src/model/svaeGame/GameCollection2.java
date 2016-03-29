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

import model.map.GameMap;
import model.tower.Tower;
import model.tower.TowerFactory;
import model.tower.shootingstrategy.TargetBasedOnNearest;
import model.tower.shootingstrategy.TargetBasedOnStrongest;
import model.tower.shootingstrategy.TargetBasedOnWeakest;
import model.tower.shootingstrategy.TowerBasedOnClosestToTower;
import view.map.Position;
import view.tower.TowerType;



public class GameCollection2 implements Serializable {

	
	private  ArrayList<GameInfo> games;
	
	public GameCollection2(){
		
		this.games = new ArrayList<>();
	}


	public void addgame(GameInfo game){
		
		games.add(game);
	}

	  public ArrayList<GameInfo> getGames() {
	        return games;
	    }
	
	  public int findGameInCollection(String gameName) { // based on map name
	        int index = 0;
	        for(int i = 0; i < games.size(); i++){
	            if(gameName.equalsIgnoreCase(games.get(i).getGameName())){
	                index = i;
	                break;
	            }
	        }
	        return index;
	    }
	  
		public void StoreInXMLFormate() throws FileNotFoundException{
			
			try{
			PrintWriter out;
			File selectedFile = new File("JSON_FILE.xml");
			 FileOutputStream stream = new FileOutputStream(selectedFile); 
             out = new PrintWriter( stream );
             out.println("<?xml version=\"1.0\"?>");
             out.println("<svaeGame version=\"1.0\">");
             
			for (int i = 0; i < games.size(); i++) {
					out.println("<Game>");
					GameInfo jsongames =games.get(i);
			        for (Map.Entry<Integer, Tower> entry : jsongames.getTowers().entrySet()) {
			        	 Tower tower =entry.getValue();
			        	 out.println("<Tower type='" + tower.getClass().getSimpleName() + "' index='" +
			        			 entry.getKey() + "' level='" + tower.getLevel() + "' strategy='" +
			        			 tower.getTowerShootingBehavior().getShootingStrategy().getClass().getSimpleName() + "' range='" + 
					        			 tower.getRange() + "' x='" + tower.getPosition().getX() + "' y='" + tower.getPosition().getY()  + "' />");

			        }
			        out.println("<WaveNumber>" + jsongames.getWaveNum() + "</WaveNumber>");
			        out.println("<MapName>" + jsongames.getMapName()+ "</MapName>");
			        out.println("<Coins>" + jsongames.getCoins() + "</Coins>");
			        out.println("<Balance>"  + jsongames.getGold() +"</Balance>");
			        out.println("<GameName>" + jsongames.getGameName() + "</GameName>");
			        out.println("</Game>");
					}
					out.println("</svaeGame>");
					out.close();
			}catch(Exception e) {
				System.out.println("Cannot Write To File ");
			}
	}
		
		public void readXMLFormate() throws Exception{
			
          	HashMap<Integer,Tower> towersCollection = new HashMap<Integer,Tower> ();
        	double balance = 0;
        	String gameName = "" ;
			String mapName = "" ;
			int waveNum = 0;
			int coins = 0;
			
			try{
			 Document xmldoc;
			 DocumentBuilder docReader = DocumentBuilderFactory.newInstance().newDocumentBuilder();
             xmldoc = docReader.parse("JSON_FILE.xml");
             Element rootElement = xmldoc.getDocumentElement();
             if ( ! rootElement.getNodeName().equals("svaeGame") )
            	 throw new Exception("File is not a svaeGame file.");
                    NodeList nodes = rootElement.getChildNodes();
                    for (int i = 0; i < nodes.getLength(); i++){

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
                                         }else if(curveOfGameElement.getTagName().equals("Tower")){
                                        	 String towerType = curveOfGameElement.getAttribute("type");
                                        	 String towerStrategy = curveOfGameElement.getAttribute("Strategy");
                                        	 int range =  Integer.parseInt(curveOfGameElement.getAttribute("range"));
                                        	 int posX = Integer.parseInt(curveOfGameElement.getAttribute("x"));
                                        	 int posY = Integer.parseInt(curveOfGameElement.getAttribute("y"));
                                        	 int index = Integer.parseInt(curveOfGameElement.getAttribute("index"));
                                        	 Tower tower = null ;
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
                                          
                                                  
                                              
                                            tower.setPosition(new Position(posX,posY));
                                            towersCollection.put(index, tower);     
                                                    	
                                        	 }
                                                          
                                                             
                                                 }
                                     
                            	 }
                            	 GameInfo gameInfo = new GameInfo(towersCollection,balance,coins,waveNum,gameName,mapName );
                                 games.add(gameInfo);
                            }
                        }
                        
		
                    }
             } catch(Exception e){
            	 System.out.println("Cannot Read From File");
             }
		}
		}

                                                    	
                      
