#include <linux/init.h>
#include <linux/module.h>
#include <linux/printk.h>
#include <linux/moduleparam.h>
#include <linux/errno.h>

#include "hello1.h"

MODULE_AUTHOR("kolomiets Dmitro");
MODULE_DESCRIPTION("Hello, it is advanced Linux Kernel Training");
MODULE_LICENSE("Dual BSD/GPL");

extern int print_hello(uint);

static uint start = 1;
module_param(start, uint, S_IRUSR | S_IWUSR | S_IRGRP | S_IWGRP);
MODULE_PARM_DESC(start, "A parameter that determines how many times the message will be displayed. Accepts values from 0-10.");

static int __init hello2_init(void)
{
  return print_hello(start);
}

static void __exit hello2_exit(void)
{
  /* Do nothing here right now */
}

module_init(hello2_init);
module_exit(hello2_exit);
