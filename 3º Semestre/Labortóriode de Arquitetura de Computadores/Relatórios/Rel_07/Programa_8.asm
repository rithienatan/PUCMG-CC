.text
.globl main
main:
addi $8, $0, 0x1234 # t0 = 7fff
sll $8, $8, 16 # t0 = 1234
ori $8, $8, 0x5678 # t0 = 12345678
sra $9, $8, 24 # $9 = 12
sll $10, $8, 8 # $10 = 345678
sra $10, $10, 24 # $10 = 34
sll $11, $8, 16 # $11 = 5678
sra $11, $11, 24 # $11 = 56
sll $12, $8, 24 # $12 = 78
sra $12, $12, 24 # $12 =