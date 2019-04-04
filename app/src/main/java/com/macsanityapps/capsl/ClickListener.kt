package com.macsanityapps.capsl

interface ClickListener<in T> {
  fun onItemClick(t : T)
}