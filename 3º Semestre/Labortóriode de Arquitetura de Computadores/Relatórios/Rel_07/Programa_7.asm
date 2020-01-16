.text
.globl main
main:
ori $8, $0, 0x01 # t0 = 1
ori $8, $8, 14 # t0 = f
or $9, $8, 0xf0 # t1 = ff
or $9, $8, 0xff0 # t1 = fff
or $9, $8, 0xfff0 # t1 = ffff
sll $9, $8, 16 # t2 = ffff 0000
or $8, $10, $9 # t0 = ffff ffff