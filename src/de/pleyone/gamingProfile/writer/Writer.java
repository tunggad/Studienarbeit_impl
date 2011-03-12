package de.pleyone.gamingProfile.writer;


import de.pleyone.gamingProfile.GamingProfileTemplate;
import de.pleyone.gamingProfile.Question;

/**
 * @author son87.lengoc@yahoo.de
 *         Created: 10.03.11 at 16:28
 */
public interface Writer {
  public String questionToString(Question question);
  public String gamingProfileTemplateToString(GamingProfileTemplate gamingProfileTemplate);
}
