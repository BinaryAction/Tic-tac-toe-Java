package ticTacToe;

public class winTables {
	public static boolean[][][] scenarios = {
			{
				{true, false, false},
				{false, true, false},
				{false, false, true}
			},
			{
				{false, false, true},
				{false, true, false},
				{true, false, false}
			},
			{
				{true, true, true},
				{false, false, false},
				{false, false, false}
			},
			{
				{false, false, false},
				{true, true, true},
				{false, false, false}
			},
			{
				{false, false, false},
				{false, false, false},
				{true, true, true}
			},
			{
				{false, true, false},
				{false, true, false},
				{false, true, false}
			},
			{
				{true, false, false},
				{true, false, false},
				{true, false, false}
			},
			{
				{false, false, true},
				{false, false, true},
				{false, false, true}
			},
			};	
}
