import com.mongodb.util.JSON;
import org.bson.Document;
import org.json.simple.JSONObject;

import java.util.Date;
import java.util.Scanner;

/**
 * Hello world!
 */
public class App {
    private   Scanner scan;
    private   String teamNumber;
    private   String competition;
    // Auto
    private   boolean crossedLineAuto;
    private   int numOfCubesToScaleAuto;
    private   int numOfCubesToPortalAuto;
    private   boolean cubesToFriendlySwitchAuto;
    private   boolean cubesToEnemySwitchAuto;
    // Tele-op
    private   int numOfCubesToScale;
    private   int numOfCubesToPortal;
    // -----------
    // these integer values have 3 choices 0 for yes 1 for no 2 for tried and failed
    private   int cubesToFriendlySwitch;
    private   int cubesToEnemySwitch;
    // -----------
    private   boolean usedPowerup;
    private   int numOfCubesForce;
    private   int numOfCubesLevitate;
    private   int numOfCubesBoost;
    private   boolean attemptedDefense;
    private   double secondsLeftWhenHeadedToRope;
    private   double secondsToGrapRope;
    private   double secondsToClimbRope;
    private   boolean climbedRope;
    private   String comment;
    private   double robotRating;
    private   int teamScore;
    private   Date date;
    private   boolean bool;
    public JSONObject run() {
        Scanner scan = new Scanner(System.in);
        System.out.println("What database do you want to use?");
        String d = scan.nextLine();
        scan = new Scanner(System.in);
        System.out.println("What competition do you want to use?");
        competition = scan.nextLine();
        RedTieMongo m = new RedTieMongo(d, competition);
        System.out.println("Do you want to enter data? If yes say 'yes', else press any key");
        String p = scan.nextLine();
        if(p.equalsIgnoreCase("yes")){
            System.out.println("What team number do you want to put info into?");
            scan = new Scanner(System.in);
            teamNumber = scan.nextLine();
            try {
                System.out.println("'true' or 'false', did the robot cross auto line?");
                scan = new Scanner(System.in);
                crossedLineAuto = Boolean.parseBoolean(scan.nextLine());
            } catch (Exception ex) {
                crossedLineAuto = false;
            }

            try {
                System.out.println("How many cubes were put to the scale in auto?");
                scan = new Scanner(System.in);
                numOfCubesToScaleAuto = Integer.parseInt(scan.nextLine());
            } catch (Exception ex) {
                numOfCubesToScaleAuto = 0;
            }
            try {
                System.out.println("How many cubes were put to the portal in auto?");
                scan = new Scanner(System.in);
                numOfCubesToPortalAuto = Integer.parseInt(scan.nextLine());
            } catch (Exception ex) {
                numOfCubesToPortalAuto = 0;
            }
            try {
                System.out.println("'true' or 'false', did the robot give cubes to the friendly switch?");
                scan = new Scanner(System.in);
                cubesToFriendlySwitchAuto = Boolean.parseBoolean(scan.nextLine());
            } catch (Exception ex) {
                cubesToFriendlySwitchAuto = false;
            }
            try {
                System.out.println("'true' or 'false', did the robot give cubes to the Enemy switch?");
                scan = new Scanner(System.in);
                cubesToEnemySwitchAuto = Boolean.parseBoolean(scan.nextLine());
            } catch (Exception ex) {
                cubesToEnemySwitchAuto = false;
            }
            try {
                System.out.println("How many cubes were put to the scale?");
                scan = new Scanner(System.in);
                numOfCubesToScale = Integer.parseInt(scan.nextLine());
            } catch (Exception ex) {
                numOfCubesToScale = 0;
            }
            try {
                System.out.println("How many cubes were put to the portal?");
                scan = new Scanner(System.in);
                numOfCubesToPortal = Integer.parseInt(scan.nextLine());
            } catch (Exception ex) {
                numOfCubesToPortal = 0;
            }
            try {
                System.out.println("Friendly Switch? 0 for yes 1 for no 2 for tried and failed ");
                scan = new Scanner(System.in);
                cubesToFriendlySwitch = Integer.parseInt(scan.nextLine());
            } catch (Exception ex) {
                cubesToFriendlySwitch = 1;
            }
            try {
                System.out.println("Enemy Switch? 0 for yes 1 for no 2 for tried and failed ");
                scan = new Scanner(System.in);
                cubesToEnemySwitch = Integer.parseInt(scan.nextLine());
            } catch (Exception ex) {
                cubesToEnemySwitch = 1;
            }
            try {
                System.out.println("'true' or 'false', did the robot do a Power Up (tm)?");
                scan = new Scanner(System.in);
                usedPowerup = Boolean.parseBoolean(scan.nextLine());
            } catch (Exception ex) {
                usedPowerup = false;
            }
            try {
                System.out.println("Number of Cubes in Force?");
                scan = new Scanner(System.in);
                numOfCubesForce = Integer.parseInt(scan.nextLine());
            } catch (Exception ex) {
                numOfCubesForce = 0;
            }
            try {
                System.out.println("Number of Cubes in Levitate?");
                scan = new Scanner(System.in);
                numOfCubesLevitate = Integer.parseInt(scan.nextLine());
            } catch (Exception ex) {
                numOfCubesLevitate = 0;
            }
            try {
                System.out.println("Number of Cubes in Boost?");
                scan = new Scanner(System.in);
                numOfCubesBoost = Integer.parseInt(scan.nextLine());
            } catch (Exception ex) {
                numOfCubesBoost = 0;
            }
            try {
                System.out.println("'true' or 'false', did the robot attempt defense?");
                scan = new Scanner(System.in);
                attemptedDefense = Boolean.parseBoolean(scan.nextLine());
            } catch (Exception ex) {
                attemptedDefense = false;
            }
            try {
                System.out.println("How many seconds were left when the robot was headed towards the rope?");
                scan = new Scanner(System.in);
                secondsLeftWhenHeadedToRope = Double.parseDouble(scan.nextLine());
            } catch (Exception ex) {
                secondsLeftWhenHeadedToRope = 0;
            }
            try {
                System.out.println("How many seconds were left when the robot was grabbing the rope?");
                scan = new Scanner(System.in);
                secondsToGrapRope = Double.parseDouble(scan.nextLine());
            } catch (Exception ex) {
                secondsToGrapRope = 0;
            }
            try {
                System.out.println("How many seconds were left when the robot was climbing the rope?");
                scan = new Scanner(System.in);
                secondsToClimbRope = Double.parseDouble(scan.nextLine());
            } catch (Exception ex) {
                secondsToClimbRope = 0;
            }
            try {
                System.out.println("'true' or 'false', did the robot climb the rope?");
                scan = new Scanner(System.in);
                climbedRope = Boolean.parseBoolean(scan.nextLine());
            } catch (Exception ex) {
                climbedRope = false;
            }
            try {
                System.out.println("Any comments");
                scan = new Scanner(System.in);
                comment = scan.nextLine();
            } catch (Exception ex) {
                comment = "No comment";
            }
            try {
                System.out.println("How would you rate the robot?");
                scan = new Scanner(System.in);
                robotRating = Double.parseDouble(scan.nextLine());
            } catch (Exception ex) {
                robotRating = 0;
            }
            try {
                System.out.println("What was the team score?");
                scan = new Scanner(System.in);
                teamScore = Integer.parseInt(scan.nextLine());
            } catch (Exception ex) {
                teamScore = 0;
            }
            Document match = new Document("TeamNumber", teamNumber)
                    .append("Competition", competition)
                    .append("CrossedLineAuto", crossedLineAuto)
                    .append("NumOfCubesToScaleAuto", numOfCubesToScaleAuto)
                    .append("NumOfCubesToPortalAuto", numOfCubesToPortalAuto)
                    .append("CubesToFriendlySwitchAuto", cubesToFriendlySwitchAuto)
                    .append("CubesToEnemySwitchAuto", cubesToEnemySwitchAuto)
                    .append("NumOfCubesToScale", numOfCubesToScale)
                    .append("NumOfCubesToPortal", numOfCubesToPortal)
                    .append("CubesToFriendlySwitch", cubesToFriendlySwitch)
                    .append("CubesToEnemySwitch", cubesToEnemySwitch)
                    .append("UsedPowerup", usedPowerup)
                    .append("NumOfCubesForce", numOfCubesForce)
                    .append("NumOfCubesLevitate", numOfCubesLevitate)
                    .append("NumOfCubesBoost", numOfCubesBoost)
                    .append("AttemptedDefense", attemptedDefense)
                    .append("SecondsLeftWhenHeadedToRope", secondsLeftWhenHeadedToRope)
                    .append("SecondsToGrapRope", secondsToGrapRope)
                    .append("SecondsToClimbRope", secondsToClimbRope)
                    .append("ClimbedRope", climbedRope)
                    .append("Comment", comment)
                    .append("RobotRating", robotRating)
                    .append("TeamScore", teamScore);
            m.getCollection().insertOne(match);
        }

        m.readDatabase();
        return m.databaseJSON();
    }

}
