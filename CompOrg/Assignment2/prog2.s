.globl prog2

#your full name: John Holcomb
#your LSU ID number: 890963950

prog2:
	pushl	%ebp			# save old ebp
	movl	%esp, %ebp		# new ebp

	pushl	%ebx			# save ebx
	pushl	%esi			# save esi

	#implement here

	# i-j+3 calculation
    movl	8(%ebp), %eax  	# i into eax
    subl	12(%ebp), %eax	# subtract j from i
    addl	$3, %eax		# add 3

	# k*10 calculation
	movl	16(%ebp), %ebx	# *k into ebx
	movl	(%ebx), %ecx	# value at *k into ecx

	leal 	(%ecx, %ecx, 4), %esi	# k * 5
    addl	%esi, %esi		# k * 2, total of k * 10
	movl	%esi, (%ebx)	# store k * 10 back to *k

	# array sum calculation
    movl	24(%ebp), %esi	# array pointer into esi
    movl	$0, %ecx		# initialize ecx

    addl	(%esi), %ecx	# add a[0]
    addl	4(%esi), %ecx	# add a[1]
    addl	8(%esi), %ecx	# add a[2]
    addl	12(%esi), %ecx	# add a[3]
    addl	16(%esi), %ecx	# add a[4]
	addl	20(%esi), %ecx	# add a[5]
	movl	20(%ebp), %ebx	# *l into ebx
	movl	%ecx, (%ebx)	# store array sum into *l
	
	# closing sequence
	popl	%esi			# restore esi
	popl	%ebx			# restore ebx

	popl	%ebp			# restore old ebp
	ret						# return, eax contains ret value
