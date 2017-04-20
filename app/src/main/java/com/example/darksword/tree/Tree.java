package com.example.darksword.tree;

/**
 * Created by Dark Sword on 4/5/2017.
 */

public class Tree
{
    private Tree previousTree;
    private Tree nextTree;
    private int payload;

    public Tree ()
    {
        this.payload = -1;
        this.nextTree = null;
        this.previousTree = null;
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
            if (this.nextTree == null)
            {
                this.setNextTree(b);
            }
            else this.nextTree.treeRecursion(i);
        }
        else if (this.getPayload() >= i)
        {
            if (this.previousTree == null)
            {
                this.setPreviousTree(b);
            }
            else this.previousTree.treeRecursion(i);
        }
    }

    public int depthCheck() //runner should always start at zero
    {
        int leftDepth = 0;
        int rightDepth = 0;
        if (this.getNextTree() != null)
        {
            rightDepth = 1 + this.getNextTree().depthCheck();
        }
        if (this.getPreviousTree() != null)
        {
            rightDepth = 1 + this.getPreviousTree().depthCheck();
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

    public Tree getNextTree()
    {
        return nextTree;
    }

    public void setNextTree(Tree nextTree)
    {
        this.nextTree = nextTree;
    }

    public Tree getPreviousTree()
    {
        return previousTree;
    }

    public void setPreviousTree(Tree previousTree)
    {
        this.previousTree = previousTree;
    }

    public int getPayload()
    {
        return payload;
    }

    public void setPayload(int payload)
    {
        this.payload = payload;
    }
}

