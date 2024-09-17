package edu.grinnell.csc207.blocks;

/**
 * The center-aligned horizontal composition of two blocks.
 *
 * @author Samuel A. Rebelsky
 * @author Jacob Bell and Myles BP
 */
public class HorizontalCompositionCenter implements AsciiBlock {
  // +--------+------------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The left block.
   */
  AsciiBlock left;

  /**
   * The right block.
   */
  AsciiBlock right;

  // +--------------+------------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Build a Horizontal Composition.
   *
   * @param leftBlock
   *   The block on the left.
   *
   * @param rightBlock
   *   The block on the right.
   */
  public HorizontalCompositionCenter(AsciiBlock leftBlock, AsciiBlock rightBlock) {
    this.left = leftBlock;
    this.right = rightBlock;
  } // HorizontalCompositionCenter

  // +---------+-----------------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Get one row from the block.
   *
   * @param i the number of the row
   *
   * @return row i.
   *
   * @exception Exception
   *   if i is outside the range of valid rows.
   */
  public String row(int i) throws Exception {
    int difference;
    int leftBig = 0;
    int rightBig;
    if (this.left.height() > this.right.height()){
      difference = (this.left.height() - this.right.height()) / 2;
      leftBig = 1; 
    } else {
      difference = (this.right.height() - this.left.height()) / 2;
    }
    if ((i < 0) || (i >= this.height())) {
      // Outside of normal bounds
      throw new Exception("Invalid row " + i);
    } else if (i < difference) { // WE ALSO REALIZE THAT WE CAN USE AN OR STATEMENT TO CHECK THE ENDING TOO.
        if (leftBig == 1){
          return this.left.row(i) + " ".repeat(this.right.width()); // WE FINISHED LAB HERE
        }
      // Inside both left and right bounds
      return this.left.row(i) + this.right.row(i);
    } else if (i < this.right.height()) {
      // Inside right bounds, outside left bounds
      return " ".repeat(this.left.width()) + this.right.row(i);
    } else {
      // Inside left bounds, outside right bounds
      return this.left.row(i) + " ".repeat(this.right.width()); 
    } // if/else
  } // row(int)

  /**
   * Determine how many rows are in the block.
   *
   * @return the number of rows
   */
  public int height() {
    return Math.max(this.left.height(), this.right.height());
  } // height()

  /**
   * Determine how many columns are in the block.
   *
   * @return the number of columns
   */
  public int width() {
    return this.left.width() + this.right.width();
  } // width()

} // class HorizontalCompositionCenter
