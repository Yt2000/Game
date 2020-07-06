package API.graphics;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CellTest {
	private static Cell cell;
	@Before
	public void setUp() throws Exception {
		cell=new Cell(20,35);
	}
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testdeleteAllCell() {
		cell.deleteAllCell();
		assertEquals(0,cell.getGrid()[0][0]);
		//fail("Not yet implemented");
	}
	@Test
	public void testgetNeighborCount() {
        cell.setNeighborCount(2, 3, 3);
        assertEquals(3,cell.getNeighborCount(2, 3));
        cell.setNeighborCount(2, 3, 2);
        assertEquals(2,cell.getNeighborCount(2, 3));
		//fail("Not yet implemented");
	}
	@Test
	public void testupdate() {
		int state=cell.getGridState(2, 3);
		cell.setNeighborCount(2, 3, 2);
		cell.update();
		assertEquals(state,cell.getGridState(2, 3));
		cell.deleteAllCell();
		cell.setNeighborCount(2, 3, 3);
		cell.update();
		assertEquals(1,cell.getGridState(2, 3));
		cell.deleteAllCell();
		cell.setNeighborCount(0, 0, 0);
		cell.update();
		assertEquals(0,cell.getGridState(2, 3));
		
		//fail("Not yet implemented");
	}
	@Test(timeout=500)
	public void testupdatetime() {
		int state=cell.getGridState(2, 3);
		cell.setNeighborCount(2, 3, 2);
		cell.update();
		assertEquals(state,cell.getGridState(2, 3),500);
	}
	@Test(expected=IllegalArgumentException.class)
	public void testgetNeighWithIllegal()
	{
		cell.getNeighborCount(-1, 1);
		cell.getNeighborCount(-1, -1);
		cell.getNeighborCount(1, -1);
	}
}

