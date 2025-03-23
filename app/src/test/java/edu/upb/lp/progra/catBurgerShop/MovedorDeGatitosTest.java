package edu.upb.lp.progra.catBurgerShop;

import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class MovedorDeGatitosTest {

    private GatoPrincipal mockGatoPrincipal;
    private MovedorDeGatitos movedorDeGatitos;

    @Before
    public void setUp() {
        //mock de GatoPrincipal
        mockGatoPrincipal = mock(GatoPrincipal.class);

        //MovedorDeGatitos con el mock
        movedorDeGatitos = new MovedorDeGatitos(mockGatoPrincipal);
    }

    @Test
    public void testStartShouldCallExecuteLater() {
        movedorDeGatitos.start();

         verify(mockGatoPrincipal).executeLater(any(Runnable.class), eq(1500));
    }

    @Test
    public void testRunShouldMoveGato() {
         movedorDeGatitos.start();

         movedorDeGatitos.run();

         verify(mockGatoPrincipal).moverAIzquierda();

         verify(mockGatoPrincipal).executeLater(any(Runnable.class), eq(500));
    }

    @Test
    public void testStopShouldStopMovement() {
        movedorDeGatitos.start();

        movedorDeGatitos.stop();

        movedorDeGatitos.run();

        verify(mockGatoPrincipal, never()).moverAIzquierda();

        verify(mockGatoPrincipal, never()).executeLater(any(Runnable.class), eq(500));
    }
}
