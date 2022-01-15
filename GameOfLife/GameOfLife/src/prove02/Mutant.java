package prove02;

import java.awt.*;
import java.util.Random;


/**
 * This mutant class I created will inherit Creature and implements Aggressor, Movable, Spawner and Aware
 * This is a Special Creature, because this mutant is a destructor
 * Mutant also move in its preferred direction
 * It will be like Wolf, but in this case, Mutants can eat whatever thing
 * Mutants check for any Wolf near of them
 */
public class Mutant extends Creature implements Aggressor, Movable, Spawner, Aware {

    private MoveDirect direct;
    private boolean mutantChild;

    public Mutant() {
        _health = 5;
        direct = MoveDirect.fromInt(new Random().nextInt(4));
        mutantChild = false;
    }

    /**
     *Mutant instances should change its preferred direction to be in the direction of the first Wolf instance it sees.
     * When checking for nearby wolves, it should first check in the direction it's already moving.
     *If no wolf instance is there, it should search in a clockwise pattern starting at the top.
     */

    @Override
    public void senseNeighbors(Creature above, Creature below, Creature left, Creature right) {
        //checking if the Creatures are null near to it
        if (left == null && below == null && above == null &&   right == null) {
            return;
        }
        //and checking for the mutant direction if there is any Wolf
        switch (direct) {
            case UP:
                if (above instanceof Wolf) {
                    return;
                }
                break;
            case RIGHT:
                if (right instanceof Wolf) {
                    return;
                }
                break;
            case LEFT:
                if (left instanceof Wolf) {
                    return;
                }
                break;
            case DOWN:
                if (below instanceof Wolf) {
                    return;
                }
                break;
            default:
                break;
        }

        //checking until find wolf, if not, it can go ahead in its preferred direction
        if (above instanceof Wolf) {
            direct = MoveDirect.UP;
        } else if (right instanceof Wolf) {
            direct = MoveDirect.RIGHT;
        } else if (below instanceof Wolf) {
            direct = MoveDirect.DOWN;
        } else if (left instanceof Wolf) {
            direct = MoveDirect.LEFT;
        }

    }
    /**
     * Mutants instances  should attack any creature they want ,
     *  and ignore null targets
     * They should inflict 7 points of damage when they attack.
     */
    @Override
    public void attack(Creature target) {
        if(target != null){
            target.takeDamage(5);
            mutantChild = true;
            _health++;
        }
    }

    @Override
    Shape getShape() {
        return Shape.Square;
    }

    //mutants are black
    @Override
    Color getColor() {
        return new Color(0, 0, 0);
    }

    @Override
    Boolean isAlive() {
        return _health > 0;
    }

    /**
     * When the move() function is called on a Mutant instance, it should move in its preferred direction.
     * When it is first created, its preferred direction should be random.
     */
    @Override
    public void move() {
        switch (direct) {
            case UP -> _location.y++;
            case RIGHT -> _location.x++;
            case DOWN -> _location.y--;
            case LEFT -> _location.x--;
            default -> {}
        }
    }

    @Override
    public Creature newCreatureSpawned() {
        if (mutantChild) {
            mutantChild = false;
            Mutant mut = new Mutant();
            mut.setLocation((Point) _location.clone());
            mut._location.x--;
            return mut;
        }
        return null; //we can't spawn
    }
}
