package edu.grinnell.csc207.blocks;

/**
 * The center-aligned horizontal composition of two blocks.
 *
 * @author Samuel A. Rebelsky
 * @author Lily Blanchard
 * @author Sarah Deschamps
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
    int numSpaces = Math.abs(left.height()-right.height());
    numSpaces /= 2;
    if (left.height() > right.height()) {
      if (i < numSpaces || i >= numSpaces + right.height()) {
        return left.row(i) + " ".repeat(right.width());
      } else {
        return left.row(i) + right.row(i-numSpaces);
      }
    } else {
      if (i < numSpaces || i >= numSpaces + left.height()) {
        return " ".repeat(left.width()) + right.row(i);
      } else {
        return left.row(i) + right.row(i-numSpaces);
      }
    }
    
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
