package edu.grinnell.csc207.blocks;

/**
 * A text block surrounded by a single letter.
 *
 * @author Samuel A. Rebelsky
 * @author Jacob Bell and Myles BP
 */
public class Surrounded implements AsciiBlock {
  // +--------+------------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The stuff in the box.
   */
  AsciiBlock contents;

  /**
   * The character we put around the box.
   */
  String boxChar;

  // +--------------+------------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Build a new block with the specified contents.
   *
   * @param blockContents
   *   The contents of the block.
   *
   * @param surroundChar
   *   The character that we use to surround the block.
   */
  public Surrounded(AsciiBlock blockContents, char surroundChar) {
    this.contents = blockContents;
    this.boxChar = Character.toString(surroundChar);
  } // Boxed(AsciiBlock)

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
   *   If the row is invalid.
   */
  public String row(int i) throws Exception {
    int h = this.contents.height();
    if (i == 0) {
      // The top of the box
      return this.boxChar.repeat(this.contents.width() + 2);
    } else if (i == h + 1) {
      // The bottom of the box
      return this.boxChar.repeat(this.contents.width() + 2);
    } else if ((i > 0) && (i <= h)) {
      // Stuff within the box
      return this.boxChar + this.contents.row(i - 1) + this.boxChar;
    } else {
      throw new Exception("Invalid row " + i);
    } // if/else
  } // row(int)

  /**
   * Determine how many rows are in the block.
   *
   * @return the number of rows
   */
  public int height() {
    return this.contents.height() + 2;   // STUB
  } // height()

  /**
   * Determine how many columns are in the block.
   *
   * @return the numbrer of columns
   */
  public int width() {
    return this.contents.width() + 2;   // STUB
  } // width()
} // class Surrounded
