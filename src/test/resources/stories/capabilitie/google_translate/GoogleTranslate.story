
Meta
!-- @my

Lifecycle:
Before:
Given the user is on the google translate page
And selected languages from 'английский' to 'русский'
When the user looks up the translation of the word 'apple'

Scenario: Looking up the translation of 'apple'
Then they should see the translation 'яблоко'

!-- Scenario: Check the number of characters entered
!-- Then number of characters must be '5'.
!--
!-- Scenario: Looking up the definition of 'apple'
!-- Then they should see the definition 'the tree which bears apples.'