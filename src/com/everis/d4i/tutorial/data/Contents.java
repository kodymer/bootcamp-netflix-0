package com.everis.d4i.tutorial.data;

import java.util.*;
import com.everis.d4i.tutorial.entities.*;

public class Contents extends HashSet<Content>{

    private static final long serialVersionUID = 1L;

    private static class ContentsHelper {
        private static final Set<Content> INSTANCE = new Contents();
    }

    public static Set<Content> getInstance() {
        return ContentsHelper.INSTANCE;
    }
}