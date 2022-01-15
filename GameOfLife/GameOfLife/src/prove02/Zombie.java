package prove02;

import java.awt.*;

/** part II
 * Zombie class should be a subclass of Creature
 * and should implement Movable and Aggressor interfaces
 * */
public class Zombie extends Creature implements Movable, Aggressor{

    //zombies created will have 1 point of life(health)
    public Zombie() {
        _health = 1;
    }


    /**
     *Instances of the zombie class should always move from left to right
     * this is a horizontal movement, so I need to add 1 in the x-axis.
     */
    @Override
    public void move() {
        _location.x++;
    }

    /**
     * Instances of the Zombie class should attack any creature they land on,
     * as long as it isn't an instance of the Plant class.
     * They should inflict 10 points of damage when they attack.
     * @param target The {@link Creature} we've encounterd.
     */
    @Override
    public void attack(Creature target) {
        //checking if target is an instance of Plant or if target is null
        if (!(target instanceof Plant) && target != null) {
            target.takeDamage(10);;
        }
    }

    //in order to be alive, _health needs to be greater than zero
    @Override
    Boolean isAlive() {
        return _health > 0;
    }

    /**
     * Instances of the Zombie class should be represented as blue squares.
     */
    @Override
    Shape getShape() {
        return Shape.Square;
    }

    /**
     *  I googled it && I've found these types of blue:
     * Color	RGB Value
     * Blue	(0, 0, 255) (I can change a value from 200-255 to have a good blue color)
     * Dark blue (0, 0, 204)
     * Very dark blue (0, 0, 153)
     * Very light green	(102, 255, 102)
     */
    @Override
    Color getColor() {
        return new Color(0, 0, 225);
    }



}
