import 'package:flutter_bloc/flutter_bloc.dart';
import 'package:flutter_playground/bloc/theme/bloc/theme_state.dart';

class ThemeCubit extends Cubit<ThemeState> {
  ThemeCubit() : super(ThemeState.initial());
  void changeTheme(int randomInt) {
    if (randomInt % 2 == 0) {
      emit(state.copyWith(appTheme: AppTheme.light));
    }else {
       emit(state.copyWith(appTheme: AppTheme.dark));
    }
  }
}
