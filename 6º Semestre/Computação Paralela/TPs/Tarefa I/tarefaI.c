/**
 * @author Rithie Natan Carvalhaes Prado
 * Matricula: 541488
 */

//----------------------- includes --------------------------------------//

#include <stdio.h>
#include <omp.h>

//-----------------------------------------------------------------------// 

int main()
{
    int i;

    #pragma omp parallel num_threads(2) // seta o número de threads em 2 
    {
        int tid = omp_get_thread_num(); // lê o identificador da thread 
        #pragma omp for
        for(i = 1; i <= 3; i++) 
        {
           printf("[PRINT1] T%d = %d \n",tid,i);
           printf("[PRINT2] T%d = %d \n",tid,i);
        }
    }
}

/**
 * @version 0.0.1 - Código sem alterações e com saida padrão:
 *       [PRINT1] T0 = 1
 *       [PRINT2] T0 = 1
 *       [PRINT1] T0 = 2
 *       [PRINT2] T0 = 2
 *       [PRINT1] T0 = 3
 *       [PRINT2] T0 = 3
 *       [PRINT1] T1 = 1
 *       [PRINT2] T1 = 4
 *-------------------------------------------------------------------------
 * @version 0.0.2 - Acrescentando a linha de código logo acima do 'for' 
 * '#pragma omp for' resultou nas seguntes saidas:
 *       [PRINT1] T0 = 1
 *       [PRINT2] T0 = 1
 *       [PRINT1] T0 = 2
 *       [PRINT2] T0 = 2
 *       [PRINT1] T1 = 3
 *       [PRINT2] T1 = 3
 */   