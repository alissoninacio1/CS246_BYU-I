package prove02;

import java.awt.*;
import java.util.Random;

/**
 * The Wolf class should be a subclass of Creature
 * and should implement the Movable, Aware, and Aggressor interfaces.
 */
public class Wolf extends Creature implements Aggressor, Movable, Aware, Spawner {

    private MoveDirect wolfDirection;
    private boolean wolfSpawn;

    /**
     * When the move() function is called on a Wolf instance, it should move in its preferred direction.
     * When it is first created, it's preferred direction should be random.
     */
    public Wolf() {
        _health = 1;
        wolfDirection = MoveDirect.fromInt(new Random().nextInt(2));
        wolfSpawn = false;
    }

    /**
     * Instances of the Wolf class should attack any Animal instances they land on,
     * but should not attack Plant or Zombie instances and ignore null targets
     * Wolves should inflict 5 points of damage when they attack.
     */

    @Override
    public void attack(Creature target) {
        if (target instanceof Zombie || target instanceof Plant || target == null) {
            return;
        }
        target.takeDamage(5);
        wolfSpawn = true;
        _health++;
    }

    /**
     *When the senseNeighbors() function is called
     *the Wolf instance should change its preferred direction to be in the direction of the first Animal instance it sees.
     * When checking for nearby animals, it should first check in the direction it's already moving.
     * If no Animal instance is there, it should search in a clockwise pattern starting at the top.
     * So, if the Wolf is moving left, it should first check the creature provided in the left parameter of senseNeighbors()
     * followed by up, then right, then down.
     */
    @Override
    public void senseNeighbors(Creature above, Creature below, Creature left, Creature right) {
        //checking if the Creatures are null

        if (left == null && below == null && above == null &&   right == null) {
            return;
        }
        //and checking for the wolfDirection
        switch (wolfDirection) {
            case UP:
                if (above instanceof Animal) {
                    return;
                }
                break;
            case RIGHT:
                if (right instanceof Animal) {
                    return;
                }
                break;
            case LEFT:
                if (left instanceof Animal) {
                    return;
                }
                break;
            case DOWN:
                if (below instanceof Animal) {
                    return;
                }
                break;
            default:
                break;
        }

        //checking until find an animal, if not, it can go ahead in its preferred direction
        if (above instanceof Animal) {
            wolfDirection = MoveDirect.UP;
        } else if (right instanceof Animal) {
            wolfDirection = MoveDirect.RIGHT;
        } else if (below instanceof Animal) {
            wolfDirection = MoveDirect.DOWN;
        } else if (left instanceof Animal) {
            wolfDirection = MoveDirect.LEFT;
        }

    }

    /**
     *For the three methods below
     * Instances of the Wolf class should be represented as gray squares.
     * if it's alive, so _health is greater than zero
     */
    @Override
    Shape getShape() {
        return Shape.Square;
    }

    @Override
    Color getColor() {
        return new Color(153, 153, 153);
    }

    @Override
    Boolean isAlive() {
        return _health > 0;
    }

    /**
     * When the move() function is called on a Wolf instance, it should move in its preferred direction.
     * When it is first created, its preferred direction should be random.
     */
    @Override
    public void move() {
        switch (wolfDirection) {
            case UP -> _location.y++;
            case RIGHT -> _location.x++;
            case DOWN -> _location.y--;
            case LEFT -> _location.x--;
            default -> {}
        }
    }

    //if wolf eats, it can generate a new wolf, only once.
    @Override
    public Creature newCreatureSpawned() {
        if (wolfSpawn) {
            wolfSpawn = false;
            Wolf kidWolf = new Wolf();
            kidWolf.setLocation((Point) _location.clone());
            kidWolf._location.x--;
            return kidWolf;
        }
        return null; //we can't spawn
    }
}