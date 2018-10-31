package patterns.abstract_factory;

/**
 * KingdomFactory factory interface.
 */
public interface KingdomFactory {

  Castle createCastle();

  King createKing();

  Army createArmy();

}
