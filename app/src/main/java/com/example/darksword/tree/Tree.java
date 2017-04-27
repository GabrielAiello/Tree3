package com.example.darksword.tree;

/**
 * Created by Dark Sword on 4/5/2017.
 */

public class Tree
{
    private Tree leftTree;
    private Tree rightTree;
    private int payload;
    private Tree parent;
    private String direction;
    private int balanceFactor;

    public Tree ()
    {
        this.payload = -1;
        this.rightTree = null;
        this.leftTree = null;
        this.parent = null;
        this.direction = "";
        this.balanceFactor = 0;
    }

    public void treeRecursion (int i)
    {
        Tree b = new Tree();
        b.setPayload(i);
        if (this.getPayload() == -1)
        {
            this.setPayload(i);
        }
        else if (this.getPayload() <= i)
        {
            if (this.rightTree == null)
            {
                b.setParent(this);
                b.setDirection("right");
                this.setRightTree(b);
            }
            else this.rightTree.treeRecursion(i);
        }
        else if (this.getPayload() >= i)
        {
            if (this.leftTree == null)
            {
                b.setParent(this);
                b.setDirection("left");
                this.setLeftTree(b);
            }
            else this.leftTree.treeRecursion(i);
        }
    }
    public int getBalanceFactor()
    {
        int leftDepth = 0;
        int righDepth = 0;
        if (this.leftTree != null)
        {
            leftDepth = 1 + this.leftTree.depthCheck();
        }
        if (this.rightTree != null)
        {
            righDepth = 1 + this.rightTree.depthCheck();
        }
        this.balanceFactor = righDepth - leftDepth;
        return this.balanceFactor;
    }
    public int depthCheck() //runner should always start at zero
    {
        int leftDepth = 0;
        int rightDepth = 0;
        if (this.getRightTree() != null)
        {
            rightDepth = 1 + this.getRightTree().depthCheck();
        }
        if (this.getLeftTree() != null)
        {
            rightDepth = 1 + this.getLeftTree().depthCheck();
        }
        if (rightDepth > leftDepth)
        {
            return rightDepth;
        }
        else
        {
            return leftDepth;
        }
    }

    public Tree getRightTree()
    {
        return rightTree;
    }

    public void setRightTree(Tree nextTree)
    {
        this.rightTree = nextTree;
    }

    public Tree getLeftTree()
    {
        return leftTree;
    }

    public void setLeftTree(Tree previousTree)
    {
        this.leftTree = previousTree;
    }

    public int getPayload()
    {
        return payload;
    }

    public void setPayload(int payload)
    {
        this.payload = payload;
    }

    public Tree getParent() {
        return parent;
    }

    public void setParent(Tree parent) {
        this.parent = parent;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }
}

