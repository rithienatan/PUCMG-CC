Nome: Rithie Natan Carvalhaes Prado
Matrícula: 541488

---------------------------Sequencial--------------------------------

real	0m0.525s
user	0m0.283s
sys	0m0.239s

--------------------Paralelo multicore em OpenMP---------------------

real	0m0.188s
user	0m0.063s
sys	0m0.387s

----------------------Paralelo GPU com OpenMP------------------------

real	0m1.696s
user	0m0.600s
sys	0m1.008s

==29177== Profiling application: ./sumGPU
==29177== Profiling result:
Time(%)      Time     Calls       Avg       Min       Max  Name
 52.63%  463.96ms         5  92.792ms     832ns  463.95ms  [CUDA memcpy HtoD]
 46.54%  410.27ms         2  205.13ms  2.4640us  410.26ms  [CUDA memcpy DtoH]
  0.84%  7.4016ms         1  7.4016ms  7.4016ms  7.4016ms  main$_omp_fn$0

==29177== API calls:
Time(%)      Time     Calls       Avg       Min       Max  Name
 36.51%  464.48ms         5  92.897ms  9.7870us  464.18ms  cuMemcpyHtoD
 32.36%  411.59ms         2  205.79ms  29.358us  411.56ms  cuMemcpyDtoH
 20.91%  266.01ms         1  266.01ms  266.01ms  266.01ms  cuCtxCreate
  7.35%  93.497ms         1  93.497ms  93.497ms  93.497ms  cuCtxDestroy
  0.58%  7.4054ms         1  7.4054ms  7.4054ms  7.4054ms  cuCtxSynchronize
  0.54%  6.8203ms         1  6.8203ms  6.8203ms  6.8203ms  cuMemFreeHost
  0.49%  6.2592ms        24  260.80us  56.363us  2.6363ms  cuLinkAddData
  0.43%  5.4226ms         1  5.4226ms  5.4226ms  5.4226ms  cuModuleLoadData
  0.37%  4.6496ms         2  2.3248ms  710.24us  3.9393ms  cuMemAlloc
  0.18%  2.3196ms         1  2.3196ms  2.3196ms  2.3196ms  cuLinkComplete
  0.12%  1.5388ms         1  1.5388ms  1.5388ms  1.5388ms  cuMemAllocHost
  0.07%  886.50us         1  886.50us  886.50us  886.50us  cuLaunchKernel
  0.07%  848.67us         2  424.34us  152.55us  696.13us  cuMemFree
  0.02%  222.48us        14  15.891us     281ns  216.77us  cuDeviceGetAttribute
  0.00%  61.451us         1  61.451us  61.451us  61.451us  cuLinkCreate
  0.00%  12.984us         8  1.6230us     735ns  3.4500us  cuMemGetAddressRange
  0.00%  7.2170us        12     601ns     394ns     997ns  cuCtxGetDevice
  0.00%  5.9400us         1  5.9400us  5.9400us  5.9400us  cuLinkDestroy
  0.00%  4.0720us         1  4.0720us  4.0720us  4.0720us  cuModuleGetFunction
  0.00%  3.2660us         3  1.0880us     488ns  1.6530us  cuDeviceGetCount
  0.00%  2.1860us         1  2.1860us  2.1860us  2.1860us  cuMemHostGetDevicePointer
  0.00%  1.2370us         1  1.2370us  1.2370us  1.2370us  cuInit
  0.00%  1.2110us         2     605ns     581ns     630ns  cuFuncGetAttribute
  0.00%  1.1820us         1  1.1820us  1.1820us  1.1820us  cuModuleGetGlobal
  0.00%  1.0990us         2     549ns     457ns     642ns  cuDeviceGet
  0.00%     611ns         1     611ns     611ns     611ns  cuCtxGetCurrent

------------------------------CUDA-----------------------------------

real	0m1.562s
user	0m0.500s
sys	0m0.972s

==29358== Profiling application: ./sumCUDA
==29358== Profiling result:
Time(%)      Time     Calls       Avg       Min       Max  Name
 96.14%  480.44ms         1  480.44ms  480.44ms  480.44ms  [CUDA memcpy HtoD]
  3.78%  18.906ms         1  18.906ms  18.906ms  18.906ms  sum_cuda(double*, double*, int)
  0.07%  364.75us         1  364.75us  364.75us  364.75us  [CUDA memcpy DtoH]

==29358== API calls:
Time(%)      Time     Calls       Avg       Min       Max  Name
 58.26%  501.82ms         2  250.91ms  19.689ms  482.13ms  cudaMemcpy
 41.52%  357.61ms         2  178.80ms  32.096us  357.58ms  cudaMalloc
  0.13%  1.1294ms         2  564.71us  29.351us  1.1001ms  cudaFree
  0.06%  483.72us        90  5.3740us     292ns  205.64us  cuDeviceGetAttribute
  0.02%  213.24us         1  213.24us  213.24us  213.24us  cudaLaunch
  0.01%  65.932us         1  65.932us  65.932us  65.932us  cuDeviceTotalMem
  0.01%  53.433us         1  53.433us  53.433us  53.433us  cuDeviceGetName
  0.00%  8.6770us         3  2.8920us     394ns  7.1850us  cudaSetupArgument
  0.00%  2.3440us         2  1.1720us     668ns  1.6760us  cuDeviceGetCount
  0.00%  1.8830us         1  1.8830us  1.8830us  1.8830us  cudaConfigureCall
  0.00%     982ns         2     491ns     394ns     588ns  cuDeviceGet

---------------------------Resultados--------------------------------

. O resultado sequencial considera a base de resultados para a execução do cálculo.

. Paralelo multicore em OpenMP speedup = 2,79.

. O resultado para paralelo em GPU e CUDA, ambos ficaram proxímos em tempo de execução. Entretanto, muito pior em relação a CPU. Além disso, o não speedup em relação ao sequencial é referente ao overhead quando é enviado dados para GPU(o mesmo acontece para o CUDA).

