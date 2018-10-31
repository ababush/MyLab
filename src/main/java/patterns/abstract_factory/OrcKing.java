package patterns.abstract_factory;

/**
 * 
 * OrcKing
 *
 */
public class OrcKing implements King {

  static final String DESCRIPTION = "This is the Orc king!";

  @Override
  public String getDescription() {
    return DESCRIPTION;
  }
}
