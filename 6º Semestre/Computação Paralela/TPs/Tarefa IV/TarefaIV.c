/** 
 * @author Rithie Natan Carvalhaes Prado
 * Matricula: 541488
 */

//----------------------- includes --------------------------------------//

#include <stdio.h>
#include <stdlib.h>
#include <omp.h>

//-----------------------------------------------------------------------// 

/**
 * Códigos testados em máquina da puc no lab 5
 * Tempo em sequencial:
 *  real    0m56,211s
 *  user    0m56,141s
 *  sys     0m0,068s
 * 
 * --------------------------------//----------------------
 * Tempo em paralelo:
 *  real    0m15,637s
 *  user    0m59,150s
 *  sys     0m0,096s
 */

void mm(double* a, double* b, double* c, int width) {
  
  #pragma omp parallel for collapse(2)
  for (int i = 0; i < width; i++) {        
    for (int j = 0; j < width; j++) {
      double   sum = 0;
      #pragma omp simd
      for (int k = 0; k < width; k++) {
        double x = a[i * width + k];
        double y = b[k * width + j];
        sum += x * y;
      }
      c[i * width + j] = sum;
    } 
  }
    
}

int main() {
  int width = 2000;
  double *a = (double*) malloc (width * width * sizeof(double));
  double *b = (double*) malloc (width * width * sizeof(double));
  double *c = (double*) malloc (width * width * sizeof(double));

  for(int i = 0; i < width; i++) {
    for(int j = 0; j < width; j++) {
      a[i*width+j] = i;
      b[i*width+j] = j;
      c[i*width+j] = 0;
    }
  }

  mm(a,b,c,width);

  //  for(int i = 0; i < width; i++) {
  //  for(int j = 0; j < width; j++) {
  //    printf("\n c[%d][%d] = %f",i,j,c[i*width+j]);
  //  }
  // }
}