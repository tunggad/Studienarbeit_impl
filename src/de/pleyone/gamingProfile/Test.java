package de.pleyone.gamingProfile;

import de.pleyone.gamingProfile.writer.Writer;
import de.pleyone.gamingProfile.writer.XMLWriter;

import java.util.ArrayList;

/**
 * @author son87.lengoc@yahoo.de
 *         Created: 10.03.11 at 17:02
 */
public class Test {
  public static void main(String[] args){
    GamingProfileTemplate gp = GamingProfileTemplateGenerator.generateOneGamingProfileTemplate();

    Writer w = new XMLWriter();
    System.out.println(w.gamingProfileTemplateToString(gp));
  }
}
