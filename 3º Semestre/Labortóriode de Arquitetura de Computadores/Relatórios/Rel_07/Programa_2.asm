.text
.globl main
main:
addi $16, $0, 0x00000001 # x = 1
add $8, $16, $16 # t0 = 2x
add $8, $8, $16 # t0 = 3x
add $8, $8, $16 # t0 = 4x
add $8, $8, $16 # t0 = 5x
addi $17, $8, 0x0000000f # y = 5x + 15